package com.ashwani.testcontainer.entity;

import org.springframework.data.annotation.Id;

public record Book (@Id Long id, String title){}
