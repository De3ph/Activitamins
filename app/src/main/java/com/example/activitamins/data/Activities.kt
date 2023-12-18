package com.example.activitamins.data

import java.util.Date

open class Activities(
    val id: Int,
    val title: String,
    var date: Date,
    val description: String,
    val organizer: String,
    var isFavourite: Boolean = false,
    var attendedUserNumber: Int = 0,
    var isUserAttended: Boolean = false
) {

}

val allActivities = listOf(
    object : Activities(
        1,
        "Conference on AI",
        Date(),
        "Have fun with this",
        "Tech Events Inc.",
        true,
        attendedUserNumber = 12238,
        isUserAttended = true
    ) {},
    object : Activities(
        2,
        "Music Festival",
        Date(),
        "Have fun with this",
        "Music Festivals Co.",
        attendedUserNumber = 1543
    ) {},
    object : Activities(
        3,
        "Fitness Workshop",
        Date(),
        "Have fun with this",
        "Health and Fitness LLC",
        attendedUserNumber = 98,
        isUserAttended = true
    ) {},
    object : Activities(
        4,
        "Community Cleanup",
        Date(),
        "Have fun with this",
        "Green Earth Organization",
        attendedUserNumber = 0
    ) {},
    object : Activities(
        5,
        "Tech Meetup",
        Date(),
        "Have fun with this",
        "Tech Enthusiasts Group",
        true,
        attendedUserNumber = 238
    ) {},
    object : Activities(
        6,
        "Art Exhibition",
        Date(),
        "Have fun with this",
        "Creative Arts Society",
        attendedUserNumber = 2060
    ) {},
    object : Activities(
        7,
        "Food Tasting",
        Date(),
        "Have fun with this",
        "Culinary Explorers Club",
        true,
        attendedUserNumber = 853
    ) {},
    object : Activities(
        8,
        "Career Fair",
        Date(),
        "Have fun with this",
        "Job Seekers Network",
        attendedUserNumber = 51,
        isUserAttended = true
    ) {},
    object : Activities(
        9,
        "Film Screening",
        Date(),
        "Have fun with this",
        "Film Buffs Association",
        attendedUserNumber = 99
    ) {},
    object : Activities(
        10,
        "Science Symposium",
        Date(),
        "Have fun with this",
        "Scientific Research Institute",
        attendedUserNumber = 126
    ) {},
    object : Activities(
        11,
        "Book Club Meeting",
        Date(),
        "Have fun with this",
        "Bookworms Society",
        true,
        attendedUserNumber = 18
    ) {},
    object : Activities(
        12,
        "Fashion Show",
        Date(),
        "Have fun with this",
        "Fashion Designers Guild",
        attendedUserNumber = 395,
        isUserAttended = true
    ) {},
)

