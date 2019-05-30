package com.springboot.webflux.service;

// Mono���0~1��������
// Flux���0~N��������
public interface UserService{
	Mono<User> getUser(Long id);
	Mono<User> insertUser(User user);
	Mono<User> updateUser<User user>;
	Mono<Void> deleteUser(Long id);
	Flux<User> findUsers(String userName, String note);
}