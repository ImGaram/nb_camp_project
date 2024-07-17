package com.example.clone_ui.data.`object`

import com.example.clone_ui.R
import com.example.clone_ui.data.PremiumAppData
import com.example.clone_ui.data.RecommendData
import com.example.clone_ui.data.SponsorAppData

object RecommendObject {
    private val recommendList = mutableListOf<RecommendData>()
    private val sponsorList = mutableListOf<SponsorAppData>()
    private val premiumList = mutableListOf<PremiumAppData>()


    init {
        addSponsorData(
            SponsorAppData(
                id = 1,
                appIcon = R.drawable.ic_game_sponsor_1,
                title = "버섯커 키우기 - 호랑이형님 콜라보 실시",
                category = "롤플레잉・캐주얼",
                starRating = 4.7,
                link = "https://play.google.com/store/apps/details?id=com.mxdzzkr.google"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 2,
                appIcon = R.drawable.ic_game_sponsor_2,
                title = "붕괴: 스타레일",
                category = "어드벤처・롤플레잉・캐주얼・싱글 플레이어",
                starRating = 4.3,
                link = "https://play.google.com/store/apps/details?id=com.HoYoverse.hkrpgoversea"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 3,
                appIcon = R.drawable.ic_game_sponsor_3,
                title = "나 혼자만 레벨업: 어라이즈",
                category = "액션",
                starRating = 4.5,
                link = "https://play.google.com/store/apps/details?id=com.netmarble.sololv"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 4,
                appIcon = R.drawable.ic_game_sponsor_4,
                title = "클래시 오브 클랜",
                category = "전략・캐주얼・싱글 플레이어",
                starRating = 4.5,
                link = "https://play.google.com/store/apps/details?id=com.supercell.clashofclans"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 5,
                appIcon = R.drawable.ic_game_sponsor_5,
                title = "원신",
                category = "어드벤처・롤플레잉・싱글 플레이어",
                starRating = 3.3,
                link = "https://play.google.com/store/apps/details?id=com.miHoYo.GenshinImpact"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 6,
                appIcon = R.drawable.ic_game_sponsor_6,
                title = "레이븐2",
                category = "롤플레잉",
                starRating = 4.4,
                link = "https://play.google.com/store/apps/details?id=com.netmarble.raven2"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 7,
                appIcon = R.drawable.ic_game_sponsor_7,
                title = "클래시 로얄",
                category = "전략・전술・캐주얼",
                starRating = 3.9,
                link = "https://play.google.com/store/apps/details?id=com.supercell.clashroyale"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 8,
                appIcon = R.drawable.ic_game_sponsor_8,
                title = "에코칼립스: 진홍의 서약",
                category = "롤플레잉",
                starRating = 4.5,
                link = "https://play.google.com/store/apps/details?id=com.yoozoo.jgame.kr"
            )
        )
        addSponsorData(
            SponsorAppData(
                id = 9,
                appIcon = R.drawable.ic_game_sponsor_9,
                title = "명조:워더링 웨이브",
                category = "액션・롤플레잉・싱글 플레이어",
                starRating = 3.6,
                link = "https://play.google.com/store/apps/details?id=com.kurogame.wutheringwaves.global"
            )
        )

        addPremiumData(
            PremiumAppData(
                id = 1,
                appIcon = R.drawable.ic_game_premium_1,
                title = "Five Nights at Freddy's",
                description = "애니매트로닉스를 잘 감시하면 아마도 밤을 버틸 수 있을 것입니다.",
                starRating = 4.8,
                price = 4000,
                link = "https://play.google.com/store/apps/details?id=com.scottgames.fivenightsatfreddys"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 2,
                appIcon = R.drawable.ic_game_premium_2,
                title = "데드 셀 - Dead Cells",
                description = "죽이고 죽고 성장하는 과정을 반복합니다.",
                starRating = 4.4,
                price = 12000,
                link = "https://play.google.com/store/apps/details?id=com.playdigious.deadcells.mobile"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 3,
                appIcon = R.drawable.ic_game_premium_3,
                title = "Terraria",
                description = "파기! 싸움! 탐험! 짓다! 수백만의 Terrarian 커뮤니티에 참여하십시오!",
                starRating = 3.6,
                price = 6500,
                link = "https://play.google.com/store/apps/details?id=com.and.games505.TerrariaPaid"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 4,
                appIcon = R.drawable.ic_game_premium_4,
                title = "Slay the Spire",
                description = "독창적인 덱을 만들고, 기이한 적들과 조우하며, 엄청난 힘을 가진 유물을 발견하고, 첨탑을 정복해보세요!",
                starRating = 4.3,
                price = 12000,
                link = "https://play.google.com/store/apps/details?id=com.humble.SlayTheSpire"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 5,
                appIcon = R.drawable.ic_game_premium_5,
                title = "Muse Dash",
                description = "바로 열혈 파쿠르와 전통 리듬게임이 조화를 이룬 세계 ㅡ \"Muse Dash\"입니다!",
                starRating = 4.3,
                price = 3900,
                link = "https://play.google.com/store/apps/details?id=com.prpr.musedash"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 6,
                appIcon = R.drawable.ic_game_premium_6,
                title = "Human Fall Flat",
                description = "세상에서 제일 웃긴 멀티플레이어 물리학 퍼즐 플랫폼 게임을 만나보세요!",
                starRating = 3.4,
                price = 7900,
                link = "https://play.google.com/store/apps/details?id=com.and.games505.humanfallflat"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 7,
                appIcon = R.drawable.ic_game_premium_7,
                title = "미니 메트로",
                description = "성장하는 도시의 지하철 노선을 설계해보세요.",
                starRating = 4.8,
                price = 1500,
                link = "https://play.google.com/store/apps/details?id=nz.co.codepoint.minimetro"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 8,
                appIcon = R.drawable.ic_game_premium_8,
                title = "Geometry Dash",
                description = "아케이드",
                starRating = 4.5,
                price = 3900,
                link = "https://play.google.com/store/apps/details?id=com.robtopx.geometryjump"
            )
        )
        addPremiumData(
            PremiumAppData(
                id = 9,
                appIcon = R.drawable.ic_game_premium_9,
                title = "스타듀 밸리 Stardew Valley",
                description = "ConcernedApe의 대인기 농장 RPG가 모바일 버전으로 찾아옵니다!",
                starRating = 4.3,
                price = 5900,
                link = "https://play.google.com/store/apps/details?id=com.chucklefish.stardewvalley"
            )
        )


        addRecommendData(RecommendData.HeaderData(1, "컨트롤러로 플레이하기"))
        addRecommendData(
            RecommendData.EventAppData(
                id = 2,
                appIcon = R.drawable.ic_game_event_1,
                title = "Minecraft",
                banner = R.drawable.ic_game_event_banner_1,
                category = "아케이드・시뮬레이션・샌드박스・캐주얼",
                starRating = 4.0,
                more = "₩11,000",
                link = "https://play.google.com/store/apps/details?id=com.mojang.minecraftpe"
            )
        )
        addRecommendData(RecommendData.HeaderData(3, "스폰서・추천"))
        addRecommendData(RecommendData.SponsorAppDataList(4, sponsorList))
        addRecommendData(RecommendData.HeaderData(5, "프리미엄 게임"))
        addRecommendData(RecommendData.PremiumAppDataList(6, premiumList))
        addRecommendData(RecommendData.HeaderData(7, "진행 중인 이벤트"))
        addRecommendData(
            RecommendData.EventAppData(
                id = 8,
                appIcon = R.drawable.ic_game_event_2,
                title = "아스팔트 레전드 유나이트",
                banner = R.drawable.ic_game_event_banner_2,
                category = "레이싱・자동차 경주・멀티플레이어・리얼리티",
                starRating = 4.3,
                link = "https://play.google.com/store/apps/details?id=com.gameloft.android.ANMP.GloftA9HM"
            )
        )
    }

    fun getRecommendList() = recommendList

    private fun addRecommendData(item: RecommendData) {
        recommendList.add(item)
    }

    private fun addSponsorData(item: SponsorAppData) {
        sponsorList.add(item)
    }

    private fun addPremiumData(item: PremiumAppData) {
        premiumList.add(item)
    }
}