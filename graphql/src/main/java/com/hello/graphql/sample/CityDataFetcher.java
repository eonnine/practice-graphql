package com.hello.graphql.sample;

import com.hello.graphql.util.graphql.Gql;
import com.hello.graphql.util.graphql.GqlDataFetcher;
import com.hello.graphql.util.graphql.GqlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@Gql
@Component
public class CityDataFetcher {
  
  @Autowired
  private CityRepository cityRepository;

  @GqlDataFetcher(type=GqlType.QUERY)
  public DataFetcher<?> allCities () {
    return environment -> {
      return cityRepository.findAll();
    };
  }

  @GqlDataFetcher(type=GqlType.QUERY)
  public DataFetcher<?> city () {
    return environment -> {
      int id = environment.getArgument("id");
      return cityRepository.findById(id);
    };
  }

}