<template>
  <div id="app">
    <header>¸
      <router-link
        :to="`/`"
      >
      <img src="/funmaths-logo.png" alt="FunMaths Logo" class="logo" />
      </router-link>
      
      <h1>{{ appName }}</h1>
    </header>
    <main>
      <router-view></router-view>
    </main>
    <footer>
      <p>&copy; 2023 FunMaths. Roko Karamatić. Završni rad na Fakultetu elektrotehnike u računarstva u Zagrebu. Sva prava zadržana.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      appName: "FunMaths",
    };
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

html,
body {
  height: 100%;
  font-family: "Arial", sans-serif;
  background-color: #f0f4f8;
}

body {
  display: flex;
  flex-direction: column;
}

#app {
  flex: 1 0 auto;
  display: flex;
  flex-direction: column;
}

header {
  background-color: #5c9ee7;
  padding: 20px 0;
  text-align: center;
}

.logo {
  max-height: 80px;
  margin-right: 10px;
  vertical-align: middle;
}

h1 {
  font-size: 2.5rem;
  color: #ffffff;
  display: inline;
}

main {
  padding: 20px;
  flex: 1 0 auto;
  min-height: calc(100vh - 180px); /* Add this line to set a minimum height for the main element */
}

footer {
  background-color: #5c9ee7;
  padding: 10px 0;
  text-align: center;
  color: #ffffff;
  flex-shrink: 0;
}

</style>