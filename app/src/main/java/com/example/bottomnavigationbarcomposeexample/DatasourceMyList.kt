package com.example.bottomnavigationbarcomposeexample

import android.annotation.SuppressLint

class DatasourceMyList() {
    @SuppressLint("ResourceType")
    fun loadWatching(): List<Watching> {
        return listOf<Watching>(
            Watching(R.string.Name1,R.string.Name2,R.string.Episode1,R.drawable.one_piece,R.drawable.your_name),
            Watching(R.string.Name3,R.string.Name4, R.string.Episode1,R.drawable.deathnote,R.drawable.sports),
            Watching(R.string.Name5,R.string.Name6, R.string.Episode1,R.drawable.dragonball,R.drawable.parasyte),
            Watching(R.string.Name7,R.string.Name8, R.string.Episode1,R.drawable.scifi,R.drawable.aot),
            Watching(R.string.Name9,R.string.Name10, R.string.Episode1,R.drawable.jojo,R.drawable.onepunchman),
            Watching(R.string.Name11,R.string.Name12, R.string.Episode1,R.drawable.scilentvoice,R.drawable.spy),
            Watching(R.string.Name13,R.string.Name14, R.string.Episode1,R.drawable.naruto,R.drawable.drama),
        )
    }
}