package org.example.y9_gaming_site.leaderboard;

import org.example.y9_gaming_site.gameRecord.GameRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LeaderboardController {

    private static final int TOP_N = 10;

    private final GameRecordService gameRecordService;

    public LeaderboardController(GameRecordService gameRecordService) {
        this.gameRecordService = gameRecordService;
    }

    // top 10 all time for game
    @GetMapping("/api/leaderboard/{gameName}")
    public List<LeaderboardEntryDto> getTopScored(@PathVariable String gameName) {
        return gameRecordService.findLeaderboard(gameName.toUpperCase(), null, TOP_N)
                .stream().map(LeaderboardEntryDto::from).toList();
    }

    // top 10 from last 24 hours for game
    @GetMapping("/api/leaderboard/{gameName}/today")
    public List<LeaderboardEntryDto> getTopScoresToday(@PathVariable String gameName) {
        LocalDateTime since = LocalDateTime.now().minusHours(24);
        return gameRecordService.findLeaderboardSince(gameName.toUpperCase(), since, TOP_N)
                .stream().map(LeaderboardEntryDto::from).toList();
    }
}
