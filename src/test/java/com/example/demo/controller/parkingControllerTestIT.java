package com.example.demo.controller;

import com.example.demo.controller.dto.ParkingCreateDTO;
import com.example.demo.controller.dto.ParkingDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class parkingControllerTestIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    // senão n encontra aplicação
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("parking")
                .then()
                .statusCode(200)
                //.body("licence[0]", Matchers.equalTo("ABC-2222"));
                .extract().response().body().prettyPrint();

    }

//    @Test
//    void whenCreateThenCheckIsCreated() {
//
//        var createDTO = new ParkingCreateDTO();
//        createDTO.setColor("AMARELO");
//        createDTO.setLicence("JJJ-1234");
//        createDTO.setModel("FUSCA");
//        createDTO.setState("SP");
//
//        RestAssured.given()
//                .when()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(createDTO)
//                .post("/parking")
//                .then()
//                .statusCode(HttpStatus.CREATED.value())
//                .body("color", Matchers.equalTo("PRETA"));
//    }
}