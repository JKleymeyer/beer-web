package com.beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beer.business.Brewery;
import com.beer.db.BreweryRepository;

@CrossOrigin
@RestController
@RequestMapping("/breweries")
public class BreweryController {

	@Autowired
	private BreweryRepository breweryRepo;

	// List of all breweries
	@GetMapping("/")
	public JsonResponse listBreweries() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(breweryRepo.findAll());

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// List brewery by Id
	@GetMapping("/{id}")
	public JsonResponse getBreweryById(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(breweryRepo.findById(id));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Add brewery to list
	@PostMapping("/")
	public JsonResponse addBrewery(@RequestBody Brewery br) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(breweryRepo.save(br));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Update brewery in list
	@PutMapping("/")
	public JsonResponse updateBrewery(@RequestBody Brewery br) {
		JsonResponse jr = null;
		try {
			if (breweryRepo.existsById(br.getId())) {
				jr = JsonResponse.getInstance(breweryRepo.save(br));
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating brewery. Id " + br.getId() + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// Delete a brewery
	@DeleteMapping("/{id}")
	public JsonResponse deleteBrewery(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (breweryRepo.existsById(id)) {
				breweryRepo.deleteById(id);
				jr = JsonResponse.getInstance("Delete successful");
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating brewery. Id " + id + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

}
