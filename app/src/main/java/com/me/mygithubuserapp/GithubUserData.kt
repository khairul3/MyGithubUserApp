package com.me.mygithubuserapp

object GithubUserData {
    private val name = arrayOf(
        "Jake Wharton",
        "Amit Shekhar",
        "Romain Guy",
        "Chris Banes",
        "David",
        "Ravi Tamada",
        "Deny Prasetyo",
        "Budi Oktaviyan",
        "Hendi Santika",
        "Sidiq Permana"
    )

    private val username = arrayOf(
        "@JakeWharton",
        "@amitshekhariitbhu",
        "@romainguy",
        "@chrisbanes",
        "@tipsy",
        "@ravi8x",
        "@jasoet",
        "@budioktaviyan",
        "@hendisantika",
        "@sidiqpermana"
    )

    private val avatar = intArrayOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5,
        R.drawable.user6,
        R.drawable.user7,
        R.drawable.user8,
        R.drawable.user9,
        R.drawable.user10
    )

    private val company = arrayOf(
        "Google, Inc.",
        "MindOrksOpenSource",
        "Google",
        "Google working on @android",
        "Working Group Two",
        "AndroidHive | Droid5",
        "gojek-engineering",
        "KotlinID",
        "JVMDeveloperID @KotlinID @IDDevOps",
        "Nusantara Beta Studio"
    )

    private val location = arrayOf(
        "Pittsburgh, PA, USA",
        "New Delhi, India",
        "California",
        "Sydney, Australia",
        "Trondheim, Norway",
        "India",
        "Kotagede, Yogyakarta, Indonesia",
        "Jakarta, Indonesia",
        "Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"
    )

    private val repository = intArrayOf(
        102,
        37,
        9,
        30,
        56,
        28,
        44,
        110,
        1064,
        65
    )

    private val followers = intArrayOf(
        56995,
        5153,
        7972,
        14725,
        788,
        18628,
        277,
        178,
        428,
        465
    )

    private val following = intArrayOf(
        12,
        2,
        0,
        1,
        0,
        3,
        39,
        23,
        61,
        10
    )

    val listData: ArrayList<GithubUser>
        get() {
            val list = arrayListOf<GithubUser>()
            for (position in username.indices) {
                val data = GithubUser()
                data.name = name[position]
                data.username = username[position]
                data.avatar = avatar[position]
                data.company = company[position]
                data.location = location[position]
                data.repository = repository[position]
                data.followers = followers[position]
                data.following = following[position]
                list.add(data)
            }
            return list
        }
}