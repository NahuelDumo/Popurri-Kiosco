import React from "react";
import { NavLink } from "react-router-dom";
function Menu() {
  return (
      <nav className="navbar navbar-dark bg-dark navbar-expand-md">

        <div className="navbar-brand-container">
          <a className="navbar-brand" >
            <i className="humble-lettering">POPURRI</i>
          </a>
        </div>

        <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ml-auto"> {/* Cambiado a ml-auto para alinear a la derecha */}
            <li className="nav-item">
              <NavLink className="nav-link" to="/inicio">
                Inicio
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/misiones">
                Productos
              </NavLink>
            </li>
          </ul>
        </div>
      </nav>
  );
}

export default Menu;
