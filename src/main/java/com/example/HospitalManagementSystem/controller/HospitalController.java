package com.example.HospitalManagementSystem.controller;

public class HospitalController {
//    @PostMapping("/register")
//    public ResponseEntity<HospitalResponseProxy> registerHospital(@RequestBody HospitalRequestProxy requestProxy) {
//        HospitalResponseProxy response = hospitalService.registerHospital(requestProxy);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    // GET /hospital/profile - hospital profile management for logged-in hospital
//    @GetMapping("/profile")
//    public ResponseEntity<HospitalResponseProxy> getProfile() {
//        HospitalResponseProxy response = hospitalService.getCurrentHospitalProfile();
//        if (response == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    // b. search available blood by group
//    @GetMapping("/search/blood/{group}")
//    public ResponseEntity<BloodStockRespnseProxy> searchBloodByGroup(@PathVariable("group") String group) {
//        BloodStockRespnseProxy response = bloodStockService.getStockByBloodGroup(group);
//        if (response == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    // c. raise blood request with quantity
//    @PostMapping("/request")
//    public ResponseEntity<BloodRequestResponseProxy> raiseBloodRequest(@RequestBody BloodRequestRequestProxy request) {
//        BloodRequestResponseProxy response = bloodRequestService.createBloodRequest(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    // d/e. track approved/rejected/pending requests & view history
//    @GetMapping("/request/history")
//    public ResponseEntity<List<BloodRequestResponseProxy>> getRequestHistory(@RequestParam Long hospitalId) {
//        List<BloodRequestResponseProxy> list = bloodRequestRepo.findAll().stream()
//                .filter(br -> br.getHospital() != null && br.getHospital().getHospitalId().equals(hospitalId))
//                .map(br -> BloodRequestResponseProxy.builder()
//                        .bloodRequestId(br.getBloodRequestId())
//                        .bloodGroup(br.getBloodGroup())
//                        .quantity(br.getQuantity())
//                        .requestDate(br.getRequestDate())
//                        .status(br.getStatus())
//                        .hospitalId(br.getHospital().getHospitalId())
//                        .build())
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
}
