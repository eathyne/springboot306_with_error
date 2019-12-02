package com.example.springboot306;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Long> {
}
