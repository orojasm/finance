package com.orojas.finance.infrastructure.rest;

import com.orojas.finance.infrastructure.rest.mapper.UserRestMapper;
import com.orojas.finance.infrastructure.rest.model.request.UserRequest;
import com.orojas.finance.infrastructure.rest.model.response.UserResponse;
import com.orojas.finance.application.ports.input.UserServicePort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
// TODO Authorize @PreAuthorize("denyAll()")
public class UserRestAdapter {
    private final UserServicePort servicePort;
    private final UserRestMapper restMapper;

    @PostMapping
    // TODO Authorize @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        log.info("Create user");
        log.info(request.toString());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toUserResponse(
                        servicePort.createUser(restMapper.toUser(request))));
    }

    @GetMapping()
    public List<UserResponse> geUsers() {
        return restMapper.toUserResponseList(servicePort.getUsers());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable UUID id) {
        return restMapper.toUserResponse(servicePort.getUserById(id));
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable UUID id, @Valid @RequestBody UserRequest request) {
        log.info("Update user");
        log.info(request.toString());

        return restMapper.toUserResponse(
                servicePort.updateUser(id, restMapper.toUser(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        servicePort.deleteUser(id);
    }

}
