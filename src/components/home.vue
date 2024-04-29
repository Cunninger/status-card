<template>
  <div class="total">
    <div class="head">
      <text class="xx">数据显示</text>
    </div>
    <div class="container">
      <!-- Nowcoder -->
      <div class="box">
        <div class="title">Nowcoder</div>
        <div class="input">
          <input type="text" v-model="NowCodertempValue" @keyup.enter="showContent" />
          <button @click="showNowCoderContent">确认</button>
        </div>
        <div class="attribute">
          <div class="left">
            <span class="text">Rating:{{ nowcoder.rating }}</span>
            <span class="text">RatingRank:{{ nowcoder.ratingRank }}</span>
          </div>
          <div class="right">
            <span class="text">CompetitionCount:{{ nowcoder.competitionCount }}</span>
            <span class="text">HasPassedProblem:{{ nowcoder.hasPassedProblem }}</span>
          </div>
        </div>
      </div>

      <!-- Leetcode -->
      <div class="box">
        <div class="title">Leetcode</div>
        <div class="input">
          <input type="text" v-model="LeetCodetempValue" @keyup.enter="showContent" />
          <button @click="showLeetCoderContent">确认</button>
        </div>
        <div class="attribute">
          <div class="left">
            <span class="text">Total_solved:{{ leetcode.total_solved }}</span>
            <span class="text">Easy_solved:{{ leetcode.easy_solved }}</span>
          </div>
          <div class="right">
            <span class="text">Medium_solved:{{ leetcode.medium_solved }}</span>
            <span class="text">Hard_solved:{{ leetcode.hard_solved }}</span>
          </div>
        </div>
      </div>

      <!-- Luogu -->
      <div class="box">
        <div class="title">Luogu</div>
        <div class="input">
          <input type="text" v-model="tempValue" @keyup.enter="showContent" />
          <button @click="showContent">确认</button>
        </div>
        <div class="attribute">
          <div class="left">
            <span class="text">Rating:{{ nowcoder.rating }}</span>
            <span class="text">RatingRank:{{ nowcoder.ratingRank }}</span>
          </div>
          <div class="right">
            <span class="text">CompetitionCount:{{ nowcoder.competitionCount }}</span>
            <span class="text">HasPassedProblem:{{ nowcoder.hasPassedProblem }}</span>
          </div>
        </div>
      </div>

      <div class="box"></div>
      <div class="box"></div>
      <div class="box"></div>
    </div>
  </div>
</template>

<script>

import axios from 'axios';
export default {
  data() {
    return {
      nowcoder:
      {
        name: '牛客',
        rating: '',
        ratingRank: '',
        competitionCount: '',
        hasPassedProblem: ''
      },
      leetcode:
      {
        name: 'Leetcode',
        total_solved: '',
        easy_solved: '',
        medium_solved: '',
        hard_solved: ''
      }

    }
  },
  methods: {
    showNowCoderContent() {
      this.$http.get('/api/nowcoder/info/' + this.NowCodertempValue)
        .then(response => {
          this.nowcoder.rating = response.data.rating
          this.nowcoder.ratingRank = response.data.ratingRank
          this.nowcoder.competitionCount = response.data.competitionCount
          this.nowcoder.hasPassedProblem = response.data.hasPassedProblem


        })
        .catch(error => {
          console.error(error);
        });
    },
    showLeetCoderContent() {
      this.$http.get('/api/leetcode/info/' + this.LeetCodetempValue)
        .then(response => {
          // this.nowcoder = response.data
          this.leetcode.easy_solved = response.data.easy_solved
          this.leetcode.medium_solved = response.data.medium_solved
          this.leetcode.hard_solved = response.data.hard_solved
          this.leetcode.total_solved = response.data.total_solved


        })
        .catch(error => {
          console.error(error);
        });
    }
  }
}

</script>


<style>
.total {
  display: flex;
  flex-direction: column;
}

.head {
  width: 100%;
  height: 80px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
  border-radius: 10px;
  display: flex;
  justify-content: flex-start;
}

.xx {
  color: #A9A9A9;
  font-size: 20px;
  font-weight: bold;
  margin-top: 20px;
  margin-left: 20px;
}

.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: first-start;
}

.box {
  flex: 1;
  width: 540px;
  height: 280px;
  display: flex;
  margin: 100px 200px 40px 100px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
  border-radius: 15px;
  width: calc((100%-500px) / 2);
  min-width: calc((100% - 500px) /2);
  max-width: calc((100% - 500px) /2);

  &:nth-child(2n) {
    margin-left: 0px;
  }

}

.title {
  margin-top: 0;
  font-weight: bold;
  font-size: 18px;
  margin-bottom: 15px;
}

.attribute {
  margin-top: 0px;
  display: flex;
}

.left {
  display: flex;
  flex-direction: column;
  margin-left: 0;
}

.right {
  display: flex;
  flex-direction: column;
  margin-left: 120px;
}

.text {
  font-size: 14px;
  margin-top: 20px;
  color: #A9A9A9
}
</style>


