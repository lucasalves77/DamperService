<h1>Aplicativo de Serviços Locais</h1>

<p>O Aplicativo de Serviços Locais é uma plataforma para conectar usuários a prestadores de serviços locais. Ele permite que os usuários naveguem, criem e agendem serviços, como reparos domésticos, limpeza e outros serviços personalizados na sua área. O app oferece suporte tanto para clientes quanto para prestadores, com funcionalidades como chat em tempo real, gerenciamento de serviços e avaliações dos usuários.</p>

<h2>Imagens das telas do app</h2>

<table>
    <tr>
        <td><img src="https://www.dropbox.com/scl/fi/072eqqzchklhtbat4srlu/Home.jpg?rlkey=uwf1u9cy6jbewj1y1396aj1oi&raw=1" alt="Tela Home do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/3ot4itx0cshdqcck4sfxh/Search.jpg?rlkey=2s5wg0elcejkfp57u4ddmnqw3&raw=1" alt="Tela Inicial do App" style="width: 100%; height: auto;"></td>
    </tr>
    <tr>
        <td><img src="https://www.dropbox.com/scl/fi/w2iyrq80fpfgerkum3pxo/Login.jpg?rlkey=g73pkqfwjk8mp679s6awpv01r&raw=1" alt="Tela de Login do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/8i2e2nxhv767pevtmpeth/Account.jpg?rlkey=cl9z993t21fjvz5t1yxu3s3pb&raw=1" alt="Tela de Conta do App" style="width: 100%; height: auto;"></td>
    </tr>
</table>

<p><a href="#mais-imagens">Ver mais imagens</a></p>

<h2>Funcionalidades</h2>
<ul>
    <li><strong>Autenticação de Usuário:</strong> Login e registro seguros usando Firebase Authentication.</li>
    <li><strong>Navegar por Serviços:</strong> Usuários podem explorar e buscar serviços na sua localidade.</li>
    <li><strong>Criar Serviço:</strong> Prestadores podem listar seus serviços com descrições, preços e disponibilidade.</li>
    <li><strong>Chat em Tempo Real:</strong> Comunicação entre prestadores de serviços e clientes usando Firebase Realtime Database.</li>
    <li><strong>Integração com PostgreSQL:</strong> Os detalhes dos serviços e os dados dos usuários são armazenados em um banco de dados PostgreSQL.</li>
    <li><strong>Serviços de Geolocalização:</strong> Integração de mapa para exibir serviços com base na localização do usuário.</li>
    <li><strong>Sistema de Agendamento:</strong> Usuários podem agendar serviços para datas e horários específicos.</li>
    <li><strong>Gerenciamento de Perfil:</strong> Prestadores e usuários podem atualizar seus perfis, incluindo detalhes dos serviços ou preferências.</li>
    <li><strong>Avaliações e Classificações:</strong> Clientes podem avaliar e comentar sobre os serviços utilizados.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Frontend:</strong> Kotlin, Jetpack Compose (Android)</li>
    <li><strong>Backend:</strong> Ktor (Kotlin), Node.js (expansão futura)</li>
    <li><strong>Banco de Dados:</strong> PostgreSQL (Amazon RDS)</li>
    <li><strong>Autenticação:</strong> Firebase Authentication (OTP e Email)</li>
    <li><strong>Dados em Tempo Real:</strong> Firebase Realtime Database</li>
    <li><strong>Carregamento de Imagens:</strong> Coil</li>
    <li><strong>Injeção de Dependências:</strong> Hilt</li>
</ul>

<h2>Instruções de Configuração</h2>

<h3>Pré-requisitos</h3>
<ul>
    <li>Android Studio (Versão mais recente)</li>
    <li>Kotlin 1.8+</li>
    <li>PostgreSQL (preferencialmente no Amazon RDS)</li>
    <li>Projeto no Firebase (Authentication, Realtime Database e Storage)</li>
</ul>

<h3>Clonar o Repositório</h3>
<pre>
<code>
https://github.com/lucasalves77/DamperService.git
</code>
</pre>

<h3>Configuração do Firebase</h3>
<ol>
    <li>Acesse o <a href="https://console.firebase.google.com/">Firebase Console</a>, crie um projeto e configure Authentication, Realtime Database e Storage.</li>
    <li>Baixe o arquivo <code>google-services.json</code> e coloque-o no diretório <code>app/</code>.</li>
    <li>Ative o login por OTP, email e recuperação de senha no Firebase Authentication.</li>
</ol>

<h3>Configuração do PostgreSQL</h3>
<ol>
    <li>Configure um banco de dados PostgreSQL. Você pode usar o <a href="https://aws.amazon.com/rds/">Amazon RDS</a> ou configurá-lo localmente.</li>
    <li>Crie as tabelas necessárias para usuários e serviços. Scripts SQL de exemplo estão disponíveis no diretório <code>/db-scripts</code>.</li>
    <li>Atualize as credenciais do banco de dados no arquivo <code>application.conf</code>.</li>
</ol>

<h3>Executar o Aplicativo</h3>
<ol>
    <li>Abra o projeto no Android Studio.</li>
    <li>Conecte seu dispositivo Android ou emulador.</li>
    <li>Sincronize o projeto com o Gradle e execute o app.</li>
</ol>

<h3>Configuração do Backend (Ktor)</h3>
<ol>
    <li>Navegue até o diretório <code>/backend</code>.</li>
    <li>Atualize o arquivo <code>application.conf</code> com as credenciais do PostgreSQL e Firebase.</li>
    <li>Execute o servidor Ktor localmente ou faça o deploy em seu servidor.</li>
</ol>

<h3>Variáveis de Ambiente</h3>
<ul>
    <li><code>POSTGRES_URL</code>: URL de conexão do PostgreSQL.</li>
    <li><code>FIREBASE_API_KEY</code>: Chave de API do Firebase para autenticação.</li>
</ul>

<h2>Contribuição</h2>
<ol>
    <li>Faça um fork do repositório.</li>
    <li>Crie uma nova branch (<code>git checkout -b feature/sua-feature</code>).</li>
    <li>Commit suas alterações (<code>git commit -m 'Adicionar sua feature'</code>).</li>
    <li>Faça o push para a branch (<code>git push origin feature/sua-feature</code>).</li>
    <li>Abra um Pull Request.</li>
</ol>

<h2 id="mais-imagens">Mais Imagens</h2>
<table>
     <tr>
        <td><img src="https://www.dropbox.com/scl/fi/e6ue71w5nk28v4ikqxmx0/Splash.jpg?rlkey=sb5j3v8nft9pp241y9xg82gbw&raw=1" alt="Tela Splash do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/cr16eq96dibi1yq9qryza/Onboarding1.jpg?rlkey=38kovvvcuw23t0amm3gvtx433&raw=1" alt="Tela de Onboarding 1 do App" style="width: 100%; height: auto;"></td>
    </tr>
    <tr>
        <td><img src="https://www.dropbox.com/scl/fi/nu9aml7rcwrqc3g6dmxvc/Onboarding2.jpg?rlkey=feg63xot6190epcxapq9mbhau&raw=1" alt="Tela de Onboarding 2 do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/pjljw5zanfwji4d21e0ae/Onboarding3.jpg?rlkey=175hxzhxsmk3fp9t1ts3wq9py&raw=1" style="width: 100%; height: auto;"></td>
    </tr>
    <tr>
        <td><img src="https://www.dropbox.com/scl/fi/w2iyrq80fpfgerkum3pxo/Login.jpg?rlkey=g73pkqfwjk8mp679s6awpv01r&raw=1" alt="Tela de Login do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/072eqqzchklhtbat4srlu/Home.jpg?rlkey=uwf1u9cy6jbewj1y1396aj1oi&raw=1" alt="Tela Home do App" style="width: 100%; height: auto;"></td>
    </tr>
    <tr>
        <td><img src="https://www.dropbox.com/scl/fi/3ot4itx0cshdqcck4sfxh/Search.jpg?rlkey=2s5wg0elcejkfp57u4ddmnqw3&raw=1" alt="Tela Inicial do App" style="width: 100%; height: auto;"></td>
        <td><img src="https://www.dropbox.com/scl/fi/8i2e2nxhv767pevtmpeth/Account.jpg?rlkey=cl9z993t21fjvz5t1yxu3s3pb&raw=1" alt="Tela de Conta do App" style="width: 100%; height: auto;"></td>
    </tr>
</table>

<h2>Licença</h2>
<p>Este projeto está licenciado sob a Licença MIT. Consulte o arquivo <code>LICENSE</code> para mais detalhes.</p>
