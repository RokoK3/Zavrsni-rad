<template>
  <div class="addition-tasks">
    <router-link to="/" class="back-link">Povratak na popis cjelina</router-link>
    <h1>Geometrija i mjerenje</h1>
    <div class="task-container" v-if="!done">
      <div class="task" v-if="tasks.length > 0">
        <div class="task-text" v-html="tasks[currentTaskIndex].taskText"></div>
        <div class="input-container">
          <input class="task-input" type="text" placeholder="Unesi odgovor" v-model="tasks[currentTaskIndex].userAnswer">
          <button class="check-btn" @click.prevent="checkAnswer(tasks[currentTaskIndex])">Provjeri</button>
          <div v-if="tasks[currentTaskIndex].resultMessage">{{ tasks[currentTaskIndex].resultMessage }}</div>
        </div>
        <div v-show="tasks[currentTaskIndex].showHintText" class="hint-text">{{ tasks[currentTaskIndex].hintText }}</div>
        <div class="hint-icon" @mouseover="tasks[currentTaskIndex].showHintTooltip = true" @mouseout="tasks[currentTaskIndex].showHintTooltip = false" @click="tasks[currentTaskIndex].showHintText = !tasks[currentTaskIndex].showHintText">
          <img src="/hint.png" alt="Hint icon">
          <span v-if="tasks[currentTaskIndex].showHintTooltip" class="hint-tooltip-text">Prikaži pomoć</span>
        </div>
      </div>
    </div>
    <button v-if="!done" class="next-task-btn" @click.prevent="nextTask">Sljedeći zadatak</button>
    <p v-if="done" class="final-message">{{ finalMessage }}</p>
    <div v-if="done && correctAnswers === tasks.length" class="reward-badge">
      <p class="reward-text">Kao nagradu za uspjeh osvojio si ovaj sticker. Nastavi točno rješavati zadatke kako bi ih sakupio sve!</p>
      <img :src="selectedSticker" alt="Reward Sticker" />
      <a :href="selectedSticker" download class="download-link">Preuzmi sticker</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdditionTasks",
  data() {
    return {
      tasks: [],
      currentTaskIndex: 0,
      correctAnswers: 0,
      done: false,
      lastTaskCompleted: false,
      selectedSticker: '',
    };
  },
  computed: {
  finalMessage() {
    if (this.correctAnswers === 0) {
      return "Nažalost nijedan zadatak nije točno riješen. Pokušaj ponovno.";
    } else if (this.correctAnswers === this.tasks.length) {
      return "Bravo, svi zadatci su točno riješeni!";
    } else {
      return `Točno si riješio/la ${this.correctAnswers}/${this.tasks.length} zadataka. Bravo!`;
    }
  },
  },
  async created() {
    await this.fetchTasks();
  },
  methods: {
    async fetchTasks() {
      this.tasks = [];
      await this.fetchTask("http://localhost:8080/povrsina/1");
      await this.fetchTask("http://localhost:8080/povrsina/4");
      await this.fetchTask("http://localhost:8080/povrsina/2");
      await this.fetchTask("http://localhost:8080/povrsina/3");
    },
    async fetchTask(url) {
      try {
        const response = await fetch(url);
        const data = await response.json();
        const newTask = {
          taskText: data.taskText,
          hintText: data.hint,
          showHintTooltip: false,
          showHintText: false,
          userAnswer: "",
          resultMessage: "",
          solution: data.solution,
          isCorrect: false,
        };
        console.log(data.solution)
        this.tasks.push(newTask);
      } catch (error) {
        console.error("Error:", error);
      }
    },
    selectSticker() {
    const randomNum = Math.floor(Math.random() * 10) + 1; // This will generate a random number between 1 and 10
    this.selectedSticker = '/sticker' + randomNum + '.png';
    },
    checkAnswer(task) {
    if (task.userAnswer.toLowerCase() === task.solution.toString()) {
        task.resultMessage = "Odgovor je točan!";
        task.isCorrect = true;
    } else {
        task.resultMessage = "Odgovor je netočan!";
        task.isCorrect = false;
    }

},

nextTask() {
  this.checkAnswer(this.tasks[this.currentTaskIndex]);

  if (this.tasks[this.currentTaskIndex].isCorrect) {
      this.correctAnswers += 1;
  }

  this.currentTaskIndex += 1;

  if (this.currentTaskIndex >= this.tasks.length) {
      this.done = true;
      this.selectSticker();
  }
},

  },
};

</script>

<style scoped>
  .final-message {
    font-size: 3rem;
    text-align: center;
    margin-top: 100px;
  }
  .addition-tasks {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  .back-link {
    display: inline-block;
    margin-bottom: 20px;
    color: #5c9ee7;
    text-decoration: none;
  }
  h1 {
    font-size: 2.5rem;
    margin-bottom: 20px;
  }
  .task-container {
    display: grid;
    grid-template-columns: 1fr;
    gap: 20px;
  }
  .task {
    position: relative;
    background-color: #ffffff;
    border-radius: 15px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    padding: 20px;
    display: flex;
    flex-direction: column;
  }
  .task-text {
    margin-bottom: 10px;
    max-width: 100%;
  }
  .input-container {
    display: flex;
    flex-direction: column;
    margin-bottom: 10px;
  }
  .task-input {
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 20%;
    margin-bottom: 10px;
  }
  .check-btn {
    background-color: #5c9ee7;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    padding: 5px 10px;
    cursor: pointer;
    transition: background-color 0.3s;
    width: 15%;
    margin-bottom: 20px;
  }
  .next-task-btn {
    display: block;
    margin: auto;
    white-space: nowrap;
    background-color: #5c9ee7;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    padding: 5px 10px;
    cursor: pointer;
    transition: background-color 0.3s;
    width: fit-content; /* This will adjust the width to fit the content */
    margin-top: 20px;
}
  .hint-icon {
    position: relative;
    display: inline-block;
    width: 24px;
    height: 24px;
    cursor: pointer;
  }
  .hint-icon img {
    width: 100%;
    height: 100%;
  }
  .hint-tooltip-text {
    visibility: hidden;
    background-color: #ffffff;
    color: #333;
    text-align: center;
    border: 1px solid #333;
    border-radius: 6px;
    padding: 5px;
    position: absolute;
    z-index: 1;
    top: 130%;
    left: 50%;
    margin-left: -50px;
    white-space: nowrap;
    opacity: 0;
    transition: opacity 0.3s;
    display: inline-block; /* Keep this line to ensure the text stays in one row */
  }
  .hint-icon:hover .hint-tooltip-text {
    visibility: visible;
    opacity: 1;
  }
  .hint-text {
    margin-top: 10px;
    margin-bottom: 5px;
    padding: 5px;
    background-color: #f8f8f8;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  .reward-badge {
  text-align: center;
  margin-top: 20px;
}

.reward-text {
  font-size: 1.5rem;
  margin-bottom: 15px;
}

.download-link {
  display: block;
  color: #5c9ee7;
  text-decoration: none;
  margin-top: 10px;
}
</style>