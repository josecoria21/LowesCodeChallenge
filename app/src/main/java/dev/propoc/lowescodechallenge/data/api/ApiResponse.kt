package dev.propoc.lowescodechallenge.data.api

interface ApiResponse {
    val cod: String
    val message: Any //Seems to be a different type when success vs failure
}
