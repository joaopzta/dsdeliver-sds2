import "./styles.css";
import { ReactComponent as Logo } from "./logo.svg"

function Navbar() {
  return (
    <nav className="main-navbar">
      <Logo />
      <a className="logo-text" href="home">DS Delilery</a>
    </nav>
  );
}

export default Navbar;