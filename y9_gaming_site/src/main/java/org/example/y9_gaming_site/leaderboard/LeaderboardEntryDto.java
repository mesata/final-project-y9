package org.example.y9_gaming_site.leaderboard;

import org.example.y9_gaming_site.gameRecord.GameRecord;

import java.time.LocalDateTime;

public record LeaderboardEntryDto(Long userId, String username, String avatarUrl, double score, LocalDateTime playedAt) {

    public static LeaderboardEntryDto from(GameRecord record) {
        return new LeaderboardEntryDto(
                record.getUser().getId(),
                record.getUser().getUsername(),
                record.getUser().getAvatarUrl(),
                record.getValue(),
                record.getRecordedAt()
        );
    }
}
