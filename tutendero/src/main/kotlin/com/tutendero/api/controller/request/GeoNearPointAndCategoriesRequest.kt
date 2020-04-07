package com.tutendero.api.controller.request

import org.springframework.data.geo.Point

class GeoNearPointAndCategoriesRequest(
        var point: Point,
        var categories: List<String>
)