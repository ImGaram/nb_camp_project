package com.example.clone_ui.data.`object`

import com.example.clone_ui.R
import com.example.clone_ui.data.PopularAppData

object PopularRankObject {
    private val popularRank = mutableListOf<PopularAppData>()
    private val ids = (1..20).toList()
    private val appIcons = listOf(
        R.drawable.ic_game_1st, R.drawable.ic_game_2nd, R.drawable.ic_game_3rd, R.drawable.ic_game_4th, R.drawable.ic_game_5th,
        R.drawable.ic_game_6th, R.drawable.ic_game_7th, R.drawable.ic_game_8th, R.drawable.ic_game_9th, R.drawable.ic_game_10th,
        R.drawable.ic_game_11th, R.drawable.ic_game_12th, R.drawable.ic_game_13th, R.drawable.ic_game_14th, R.drawable.ic_game_15th,
        R.drawable.ic_game_16th, R.drawable.ic_game_17th, R.drawable.ic_game_18th, R.drawable.ic_game_19th, R.drawable.ic_game_20th,
    )
    private val titles = listOf(
        "미니히어로즈: Reborn - 6666뽑기 증정", "돌격! 기사단 : 방치형 RPG", "로드나인", "무제", "운빨존많겜",
        "고스톱M : 데이터 필요없는 맞고 게임", "냥킹덤", "데이터 필요없는 게임 - 와이파이 필요없는 게임", "고잉 프린세스 : 기사단 키우기", "쿠키런: 모험의 탑",
        "월드 크러쉬 : 히어로 포스", "어나더던전", "젠레스 존 제로", "Block Blast!", "편의점 정리왕: 매치 마스터",
        "네오 서울 : 좀비 디펜스", "로얄 매치 Royal Match", "루나 모바일", "국민 고스톱 : 맞고 게임", "냥코 대전쟁"
    )
    private val categories = listOf(
        "신규・롤플레잉", "신규・롤플레잉", "신규・롤플레잉", "신규・롤플레잉", "신규・전략・타워 디펜스・캐주얼",
        "카드・캐주얼・멀티플레이어", "신규・롤플레잉", "캐주얼・미니 게임・오프라인・싱글 플레이어", "신규・롤플레잉・방치형 RPG", "신규・액션・캐주얼・싱글 플레이어",
        "캐주얼", "롤플레잉・방치형 RPG・캐주얼", "신규・롤플레잉", "퍼즐・블록・캐주얼・오프라인", "퍼즐",
        "신규・전략", "퍼즐・매치3 어드벤처・캐주얼・오프라인", "롤플레잉", "보드・바둑・멀티플레이어", "캐주얼・전략・타워 디펜스・오프라인"
    )
    private val starRatings = listOf(4.6, 4.5, 4.0, 4.1, 4.4, 4.5, 4.6, 4.6, 4.5, 4.7, 4.3, 4.3, 3.8, 4.4, 4.6, 4.7, 4.6, 4.3, 4.0, 4.1)
    private val events = listOf(
        "", "", "", "", "\uD83C\uDF96 에디터 추천", "", "", "", "⟳ 주요 업데이트", "\uD83C\uDF96 에디터 추천", "", "", "⟳ 주요 업데이트", "",
        "", "", "\uD83C\uDF96 에디터 추천 ⟳ 주요 업데이트", "", "", "\uD83D\uDCC5 이벤트・24/7/29에 종료"
    )
    private val links = listOf(
        "https://play.google.com/store/apps/details?id=com.and.brawl.kr", "https://play.google.com/store/apps/details?id=com.gaimstudio.knightage", "https://play.google.com/store/apps/details?id=com.smilegate.lordnine.stove.google",
        "https://play.google.com/store/apps/details?id=com.enp.muje.google", "https://play.google.com/store/apps/details?id=com.percent.aos.luckydefense", "https://play.google.com/store/apps/details?id=com.noriworks.gm",
        "https://play.google.com/store/apps/details?id=com.fathermade.catkingdom", "https://play.google.com/store/apps/details?id=com.JindoBlu.OfflineGames", "https://play.google.com/store/apps/details?id=com.bluepotiongames.gp.google",
        "https://play.google.com/store/apps/details?id=com.devsisters.cba", "https://play.google.com/store/apps/details?id=com.hero.legend.mmo", "https://play.google.com/store/apps/details?id=net.gameduo.anotherdungeon",
        "https://play.google.com/store/apps/details?id=com.HoYoverse.Nap", "https://play.google.com/store/apps/details?id=com.block.juggle", "https://play.google.com/store/apps/details?id=com.actionfit.convenisort",
        "https://play.google.com/store/apps/details?id=com.cereels.neoseoul.gl", "https://play.google.com/store/apps/details?id=com.dreamgames.royalmatch", "https://play.google.com/store/apps/details?id=com.soulgames.luna19",
        "https://play.google.com/store/apps/details?id=com.noriworks.kg", "https://play.google.com/store/apps/details?id=jp.co.ponos.battlecatskr"
    )

    fun getPopularRank(): MutableList<PopularAppData> = popularRank

    fun initPopularRank() {
        for (i in 0 until 20) {
            popularRank.add(
                PopularAppData(
                    id = ids[i],
                    rank = ids[i],
                    appIcon = appIcons[i],
                    title = titles[i],
                    category = categories[i],
                    starRating = starRatings[i],
                    event = events[i],
                    link = links[i]
                )
            )
        }
    }
}