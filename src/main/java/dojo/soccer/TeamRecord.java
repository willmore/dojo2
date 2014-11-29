package dojo.soccer;

public class TeamRecord {

    private int position;
    private String name;
    private int plays;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;

    private TeamRecord(Builder builder) {
        this.position = builder.position;
        this.name = builder.name;
        this.plays = builder.plays;
        this.wins = builder.wins;
        this.draws = builder.draws;
        this.losses = builder.losses;
        this.goalsFor = builder.goalsFor;
        this.goalsAgainst = builder.goalsAgainst;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPlays() {
        return plays;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }


    public static class Builder {
        private int position;
        private String name;
        private int plays;
        private int wins;
        private int draws;
        private int losses;
        private int goalsFor;
        private int goalsAgainst;

        public static Builder teamRecord() {
            return new Builder();
        }

        public Builder withPosition(int position) {
            this.position = position;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPlays(int plays) {
            this.plays = plays;
            return this;
        }

        public Builder withWins(int wins) {
            this.wins = wins;
            return this;
        }

        public Builder withDraws(int draws) {
            this.draws = draws;
            return this;
        }

        public Builder withLosses(int losses) {
            this.losses = losses;
            return this;
        }

        public Builder withGoalsFor(int goalsFor) {
            this.goalsFor = goalsFor;
            return this;
        }

        public Builder withGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
            return this;
        }

        public TeamRecord build() {
            return new TeamRecord(this);
        }
    }

}
