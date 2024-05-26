import React from "react";
import { useNavigate } from "react-router-dom";
import './FormularioLogin.css';

function FormularioLoginUsuario({ evento_atualizar, evento_logar }) {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate("/FormularioCadastroUsuario");
    }

    return (
        <>
            <div className="bodyitens">
                <div className='bodydiv'>
                    <form className="d-flex flex-column">
                        <div className="d-flex flex-column">
                            <label>Email</label>
                            <input type="email" name="email" onChange={evento_atualizar} />
                        </div>
                        <div className="d-flex flex-column">
                            <label>Senha</label>
                            <input type="password" name="senha" onChange={evento_atualizar} />
                        </div>
                        
                        <input className="cadbutton mt-4" type="button" onClick={evento_logar} value="Entrar" />
                        
                        <div>
                       
                        <button className='cadastrese mt-4' onClick={handleClick}> Cadastre-se </button>
                        </div>
                    </form>
                </div>
                
            </div>
            <div className='rodape'></div>
        </>
    );
}

export default FormularioLoginUsuario;