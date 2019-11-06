package com.beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beer.business.Beer;
import com.beer.db.BeerRepository;
import com.beer.web.JsonResponse;

@CrossOrigin
@RestController
@RequestMapping("/beers")
public class BeerController {

	@Autowired
	private BeerRepository beerRepo;

	// List of all beers
	@GetMapping("/")
	public JsonResponse listBeers() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(beerRepo.findAll());

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// List beer by Id
	@GetMapping("/{id}")
	public JsonResponse getBeerById(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(beerRepo.findById(id));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Add beer to list
	@PostMapping("/")
	public JsonResponse addBeer(@RequestBody Beer b) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(beerRepo.save(b));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Update beer in list
	@PutMapping("/")
	public JsonResponse updateBeer(@RequestBody Beer b) {
		JsonResponse jr = null;
		try {
			if (beerRepo.existsById(b.getId())) {
				jr = JsonResponse.getInstance(beerRepo.save(b));
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating beer. Id " + b.getId() + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// Delete a beer
	@DeleteMapping("/{id}")
	public JsonResponse deleteBeer(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (beerRepo.existsById(id)) {
				beerRepo.deleteById(id);
				jr = JsonResponse.getInstance("Delete successful");
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating beer. Id " + id + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

}
