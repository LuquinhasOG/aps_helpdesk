import { useNavigate } from 'react-router-dom';
import './FormularioCadastro.css';

function FormularioCadastroUsuario({evento_atualizar, evento_cadastrar_usuario}:any) {
    return (
        <><div className="bodyitens">
            <div className='bodydiv a'>
                <form className="d-flex flex-column">

                    <div className="d-flex flex-column">
                        <label>Nome do usuário</label>
                        <input type="text" name="nome" onChange={evento_atualizar} />
                    </div>
                    <div className="d-flex flex-column">
                        <label>E-mail</label>
                        <input type="email" name="email" onChange={evento_atualizar} />
                    </div>
                    <div className="d-flex flex-column">
                        <label>Senha</label>
                        <input type="password" name="senha" onChange={evento_atualizar} />
                    </div>
                    <div className="d-flex flex-column">
                        <label>Data de nascimento</label>
                        <input type="date" name="dataNascimento" onChange={evento_atualizar} />
                    </div>
                    
                    <input className="cadbutton mt-4" type="button" value="Cadastrar" onClick={evento_cadastrar_usuario} />
                    
                </form>
            </div>

        </div><div className='rodape'></div></>
    );
}

export default FormularioCadastroUsuario;
