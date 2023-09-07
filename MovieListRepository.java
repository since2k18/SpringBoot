package com.instanotes.movies.dataaccess;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instanotes.movies.model.Data;

public interface MovieListRepository extends JpaRepository<Data, Long>{
	
	List<Data> findMoviesByActor(String name);
}
