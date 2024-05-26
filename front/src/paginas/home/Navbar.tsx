import { useNavigate } from "react-router-dom";
import './Home.css';

function NavBar() {
    const mudarPagina = useNavigate()
    const handleClick = (event: any) => {
        mudarPagina(event.target.name)
    }
    return (
        <div className='navbardiv'>
            <div className='logo'>
                <img className='logo' src='src\paginas\home\APS24.png' alt='logo' />
            </div>
            <div className='navbaritens'>
                <nav>
                    <ul className='listitem'>
                        <li>
                        <button className='listext' name="./Home" onClick={handleClick} >HOME</button>
                        </li>
                        <li>
                            <button className='listext' name="./Ticket" onClick={handleClick} >TICKETS</button>
                            
                        </li>
                        <li>
                        <button className='listext' name="./FormularioLoginUsuario" onClick={handleClick} >ENTRE</button>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    )
}
export default NavBar;