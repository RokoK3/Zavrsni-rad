<template>
    <div class="addition-tasks">
      <router-link to="/" class="back-link">Povratak na popis cjelina</router-link>
      <h1>Addition Tasks</h1>
      <div class="task-container">
        <div class="task" v-for="i in 3" :key="i">
          <div class="task-text">Task text {{ i }}</div>
          <div class="input-container">
            <input class="task-input" type="text" placeholder="Unesi odgovor">
            <button class="check-btn">Provjeri</button>
          </div>
          <div class="hint-icon" @mouseover="showTooltip = true" @mouseout="showTooltip = false">
            <img src="/hint.png" alt="Hint icon">
            <span v-if="showTooltip" class="hint-tooltip-text">Prikaži pomoć</span>
          </div>
          <div class="regen-icon" @mouseover="showRegenTooltip = true" @mouseout="showRegenTooltip = false">
          <img src="/regeneriraj.png" alt="Regen icon">
          <span v-if="showRegenTooltip" class="regen-tooltip-text">Regeneriraj ovaj zadatak</span>
        </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "AdditionTasks",
    data() {
      return {
        showTooltip: false,
        showRegenTooltip: false,
      };
    },
  };
  </script>
  
  <style scoped>
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
}

.regen-icon {
  position: relative;
  display: inline-block;
  width: 24px;
  height: 24px;
  cursor: pointer;
  margin-right: 20px;
  margin-top: 1px;
}
.hint-icon {
  position: relative;
  display: inline-block;
  width: 24px;
  height: 24px;
  cursor: pointer;
}

.regen-icon img {
  width: 200%;
  height: 200%;
}
.hint-icon img {
  width: 100%;
  height: 100%;
}
.regen-tooltip-text {
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
  margin-left: -60px;
  margin-top: 15px;
  white-space: nowrap;
  opacity: 0;
  transition: opacity 0.3s;
  display: inline-block; /* Keep this line to ensure the text stays in one row */
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
.hint-icon:hover .hint-tooltip-text,
.regen-icon:hover .regen-tooltip-text {
  visibility: visible;
  opacity: 1;
}

.regen-icon {
  position: absolute;
  top: 10px;
  right: 10px;
}
</style>