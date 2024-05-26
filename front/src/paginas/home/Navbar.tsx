import { useNavigate } from "react-router-dom";
import './Home.css';
import UsuarioServico from "../../servicos/UsuarioServico";

const usuarioService = new UsuarioServico;

function NavBar() {
    const mudarPagina = useNavigate()

    const handleClick = (event: any) => {
        mudarPagina(event.target.name)
    }

    const deslogar = () => {
        usuarioService.logout();
        location.reload()
        mudarPagina("../login");
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
                        <button className='listext' name="./" onClick={handleClick} >HOME</button>
                        </li>
                        <li>
                            <button className='listext' name="./centrodechamados" onClick={handleClick} >CHAMADOS</button>
                            
                        </li>
                        <li>
                           { (usuarioService.validarLogin()) ?
                            <button className='listext' onClick={deslogar} >SAIR</button>
                            : <button className='listext' name="./login" onClick={handleClick} >ENTRE</button> }
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    )
}
export default NavBar;