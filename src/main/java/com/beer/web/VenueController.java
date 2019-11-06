package com.beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beer.business.Venue;
import com.beer.db.VenueRepository;

@CrossOrigin
@RestController
@RequestMapping("/venues")
public class VenueController {

	@Autowired
	private VenueRepository venueRepo;

	// List venue
	@GetMapping("/")
	public JsonResponse listVenue() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(venueRepo.findAll());

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// List venue by Id
	@GetMapping("/{id}")
	public JsonResponse getVenueById(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(venueRepo.findById(id));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Add venue
	@PostMapping("/")
	public JsonResponse addVenue(@RequestBody Venue v) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(venueRepo.save(v));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Update venue in list
	@PutMapping("/")
	public JsonResponse updateVenue(@RequestBody Venue v) {
		JsonResponse jr = null;
		try {
			if (venueRepo.existsById(v.getId())) {
				jr = JsonResponse.getInstance(venueRepo.save(v));
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating venue. Id " + v.getId() + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// Delete on tap
	@DeleteMapping("/{id}")
	public JsonResponse deleteVenue(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (venueRepo.existsById(id)) {
				venueRepo.deleteById(id);
				jr = JsonResponse.getInstance("Delete successful");
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating venue. Id " + id + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

}
