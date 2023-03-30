const festivalDropdown = document.querySelector('#festival-dropdown');
const festivalMenu = document.querySelector('#festival-menu');

festivalDropdown.addEventListener('click', () => {
  festivalMenu.classList.toggle('show');
});