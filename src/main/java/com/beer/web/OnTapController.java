package com.beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beer.business.OnTap;
import com.beer.db.OnTapRepository;

@CrossOrigin
@RestController
@RequestMapping("/ontaps")
public class OnTapController {
	
	@Autowired
	private OnTapRepository ontapRepo;
	
	// List on tap
	@GetMapping("/")
	public JsonResponse listOnTap() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(ontapRepo.findAll());

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// List on tap by Id
	@GetMapping("/{id}")
	public JsonResponse getOnTapById(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(ontapRepo.findById(id));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Add on tap to list
	@PostMapping("/")
	public JsonResponse addOnTap(@RequestBody OnTap o) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(ontapRepo.save(o));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;

	}

	// Update on tap in list
	@PutMapping("/")
	public JsonResponse updateOnTap(@RequestBody OnTap o) {
		JsonResponse jr = null;
		try {
			if (ontapRepo.existsById(o.getId())) {
				jr = JsonResponse.getInstance(ontapRepo.save(o));
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating on tap. Id " + o.getId() + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}

	// Delete on tap
	@DeleteMapping("/{id}")
	public JsonResponse deleteOnTap(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			if (ontapRepo.existsById(id)) {
				ontapRepo.deleteById(id);
				jr = JsonResponse.getInstance("Delete successful");
			} else {
				// record doesn't exist
				jr = JsonResponse.getInstance("Error updating on tap. Id " + id + " doesn't exist");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);

		}
		return jr;
	}
}
