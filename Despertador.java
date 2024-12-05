import java.time.*;  // Importa classes do pacote java.time para lidar com data e hora
import java.util.*;  // Importa classes do pacote java.util para manipulação de coleções e utilitários
import javax.sound.sampled.*;  // Importa classes para manipulação de áudio

public class Despertador {  // Declara a classe principal "Despertador"
    public static void main(String[] args) {  // Método principal, onde o programa começa a execução
        int horaAtual = LocalDateTime.now().getHour();  // Obtém a hora atual do sistema
        int horaDespertar = -1;  // Inicializa a variável para hora do despertador com valor inválido (-1)
        int horaRestante = -1;  // Inicializa a variável para a hora restante com valor inválido (-1)

        int minutoAtual = LocalDateTime.now().getMinute();  // Obtém o minuto atual do sistema
        int minutoDespertar = -1;  // Inicializa a variável para minuto do despertador com valor inválido (-1)
        int minutoRestante = -1;  // Inicializa a variável para o minuto restante com valor inválido (-1)

        int segundoAtual = LocalDateTime.now().getSecond();  // Obtém o segundo atual do sistema
        int segundoRestante = -1;  // Inicializa a variável para segundo restante com valor inválido (-1)

        boolean adiarDespertador = false;  // Define se o alarme será adiado, inicialmente é falso
        int tempoMaximoSoneca = 10;  // Define o tempo máximo de soneca em minutos
        boolean volumeCrescente = false;  // Define se o volume do alarme será crescente, inicialmente é falso
        boolean encerrarDespertador = false;  // Define se o despertador deve ser encerrado, inicialmente é falso
        boolean respostaErrada = true;  // Inicializa uma variável para controlar a resposta do usuário

        String respostaUsuario;  // Variável para armazenar a resposta do usuário
        String nomeDespertador;  // Variável para armazenar o nome do despertador

        Scanner inputScanner = new Scanner(System.in);  // Cria um scanner para ler entradas do usuário

        while (respostaErrada == true) {  // Enquanto a resposta estiver errada, repete o loop
            clearScreen();  // Limpa a tela do terminal

            horaAtual = LocalDateTime.now().getHour();  // Atualiza a hora atual
            minutoAtual = LocalDateTime.now().getMinute();  // Atualiza o minuto atual
            segundoAtual = LocalDateTime.now().getSecond();  // Atualiza o segundo atual

            System.out.println("Agora são: " + horaAtual + "h:" + minutoAtual + "m:" + segundoAtual + "s");  // Exibe a hora atual
            System.out.println("Digite abaixo SOMENTE NÚMERO INTEIRO (de 0 a 23) a hora do despertador e tecle enter:");  // Solicita a hora para o despertador
            respostaUsuario = inputScanner.nextLine().trim();  // Lê a entrada do usuário

            try {  // Tenta converter a resposta para um número inteiro
                horaDespertar = Integer.valueOf(respostaUsuario);  // Converte a resposta para um número inteiro e define a hora do despertador
                respostaErrada = false;  // Se não houver erro, a resposta foi correta
            } catch (Exception e) {  // Se ocorrer um erro ao tentar converter
                System.out.println("Resposta inválida! Verifique sua digitação e tente novamente.");  // Exibe mensagem de erro
                try {
                    Thread.sleep(5000);  // Aguarda 5 segundos antes de permitir uma nova tentativa
                } catch (Exception ev) {
                    System.err.println("Erro: " + ev);  // Captura erros ao dormir
                }
            }
        }

        respostaErrada = true;  // Reinicia a variável respostaErrada para repetir o próximo loop

        while (respostaErrada == true) {  // Enquanto a resposta estiver errada, repete o loop
            clearScreen();  // Limpa a tela do terminal

            horaAtual = LocalDateTime.now().getHour();  // Atualiza a hora atual
            minutoAtual = LocalDateTime.now().getMinute();  // Atualiza o minuto atual
            segundoAtual = LocalDateTime.now().getSecond();  // Atualiza o segundo atual

            System.out.println("Agora são: " + horaAtual + "h:" + minutoAtual + "m:" + segundoAtual + "s");  // Exibe a hora atual
            System.out.println("Digite abaixo SOMENTE NÚMERO INTEIRO (de 0 a 59) o minuto do despertador e tecle enter:");  // Solicita o minuto para o despertador
            respostaUsuario = inputScanner.nextLine().trim();  // Lê a entrada do usuário

            try {  // Tenta converter a resposta para um número inteiro
                minutoDespertar = Integer.valueOf(respostaUsuario);  // Converte a resposta para um número inteiro e define o minuto do despertador
                respostaErrada = false;  // Se não houver erro, a resposta foi correta
            } catch (Exception e) {  // Se ocorrer um erro ao tentar converter
                System.out.println("Resposta inválida! Verifique sua digitação e tente novamente.");  // Exibe mensagem de erro
                try {
                    Thread.sleep(5000);  // Aguarda 5 segundos antes de permitir uma nova tentativa
                } catch (Exception ev) {
                    System.err.println("Erro: " + ev);  // Captura erros ao dormir
                }
            }
        }

        respostaErrada = true;  // Reinicia a variável respostaErrada para o próximo loop
        while (respostaErrada == true) {  // Enquanto a resposta estiver errada, repete o loop
            clearScreen();  // Limpa a tela do terminal
            System.out.println("Deseja adiar o alarme quando tocar?");  // Pergunta se o usuário quer adiar o alarme
            System.out.println("Digite a opção abaixo e tecle enter:");  // Solicita a opção de resposta
            System.out.println("[s] - Sim");  // Opção para sim
            System.out.println("[n] - Não");  // Opção para não

            respostaUsuario = inputScanner.nextLine();  // Lê a resposta do usuário
            if (respostaUsuario.trim().equals("s") || respostaUsuario.trim().equals("S")) {  // Verifica se a resposta é "sim"
                adiarDespertador = true;  // Define que o alarme pode ser adiado
                respostaErrada = false;  // Resposta correta
            } else if (respostaUsuario.equals("n") || respostaUsuario.equals("N")) {  // Verifica se a resposta é "não"
                adiarDespertador = false;  // Define que o alarme não pode ser adiado
                respostaErrada = false;  // Resposta correta
            } else {  // Se a resposta for inválida
                System.out.println("Resposta inválida! Verifique sua digitação e tente novamente.");  // Exibe mensagem de erro
                try {
                    Thread.sleep(5000);  // Aguarda 5 segundos antes de permitir nova tentativa
                } catch (Exception ev) {
                    System.err.println("Erro: " + ev);  // Captura erros ao dormir
                }
            }
        }

        clearScreen();  // Limpa a tela
        System.out.println("Digite abaixo o nome do despertador e tecle enter:");  // Solicita o nome do despertador

        respostaUsuario = inputScanner.nextLine();  // Lê o nome do despertador
        nomeDespertador = respostaUsuario;  // Armazena o nome do despertador

        respostaErrada = true;  // Reinicia a variável respostaErrada
        while (respostaErrada == true) {  // Enquanto a resposta estiver errada, repete o loop
            clearScreen();  // Limpa a tela

            System.out.println("Deseja o volume crescente?");  // Pergunta se o volume será crescente
            System.out.println("Digite abaixo a opção desejada e tecle Enter:");  // Solicita a opção de resposta
            System.out.println("[s] - Sim");  // Opção para sim
            System.out.println("[n] - Não");  // Opção para não

            respostaUsuario = inputScanner.nextLine();  // Lê a resposta do usuário
            if (respostaUsuario.equals("s") || respostaUsuario.equals("S")) {  // Verifica se a resposta é "sim"
                volumeCrescente = true;  // Define que o volume será crescente
                respostaErrada = false;  // Resposta correta
            } else if (respostaUsuario.equals("n") || respostaUsuario.equals("N")) {  // Verifica se a resposta é "não"
                volumeCrescente = false;  // Define que o volume não será crescente
                respostaErrada = false;  // Resposta correta
            } else {  // Se a resposta for inválida
                System.out.println("Resposta inválida! Verifique sua digitação e tente novamente.");  // Exibe mensagem de erro
                try {
                    Thread.sleep(5000);  // Aguarda 5 segundos antes de permitir nova tentativa
                } catch (Exception ev) {
                    System.err.println("Erro: " + ev);  // Captura erros ao dormir
                }
            }
        }

        while (encerrarDespertador == false) {  // Loop que continua até o despertador ser encerrado
            clearScreen();  // Limpa a tela

            horaAtual = LocalDateTime.now().getHour();  // Atualiza a hora atual
            minutoAtual = LocalDateTime.now().getMinute();  // Atualiza o minuto atual
            segundoAtual = LocalDateTime.now().getSecond();  // Atualiza o segundo atual

            if (horaAtual > 0) {  // Verifica se a hora atual é maior que 0
                horaRestante = (24 - horaAtual) + horaDespertar;  // Calcula as horas restantes para o despertador
            } else {
                horaRestante = horaDespertar;  // Se a hora atual for 0, define a hora restante como a hora do despertador
            }

            if (minutoAtual > 0) {  // Verifica se o minuto atual é maior que 0
                minutoRestante = (60 - minutoAtual) + minutoDespertar;  // Calcula os minutos restantes
            } else {
                minutoRestante = minutoDespertar;  // Se o minuto atual for 0, define os minutos restantes como o minuto do despertador
            }

            if (segundoAtual > 0) {  // Verifica se o segundo atual é maior que 0
                segundoRestante = 60 - segundoAtual;  // Calcula os segundos restantes
            } else {
                segundoRestante = segundoAtual;  // Se o segundo atual for 0, define os segundos restantes
            }

            if (segundoRestante > 59) {  // Se o segundo restante for maior que 59, ajusta para 0
                segundoRestante = 0;
            }

            if (horaAtual == horaDespertar && minutoAtual >= minutoDespertar && minutoAtual <= (minutoDespertar + tempoMaximoSoneca)) {  // Verifica se chegou a hora de disparar o despertador
                tocarSom(volumeCrescente);  // Toca o som do despertador com volume crescente ou não
                System.out.println("O despertador: " + nomeDespertador + " está ativo.");  // Exibe mensagem que o despertador está ativo
                if (adiarDespertador == true) {  // Se o alarme pode ser adiado
                    respostaErrada = true;  // Reinicia a variável para permitir novas tentativas
                    while (respostaErrada == true) {  // Repete o loop até a resposta ser correta
                        System.out.println("Adiar alarme?");  // Pergunta se o usuário deseja adiar
                        System.out.println("Digite abaixo a opção desejada e tecle enter:");  // Solicita a opção
                        System.out.println("[5] - adiar 5 minutos");  // Opção para adiar 5 minutos
                        System.out.println("[10] - adiar 10 minutos");  // Opção para adiar 10 minutos
                        System.out.println("[s] - sair");  // Opção para sair
                        respostaUsuario = inputScanner.nextLine().trim();  // Lê a resposta do usuário
                        if (respostaUsuario.equals("s") || respostaUsuario.equals("S")) {  // Se a resposta for "s" ou "S"
                            inputScanner.close();  // Fecha o scanner
                            System.exit(0);  // Encerra o programa
                        } else if (respostaUsuario.equals("5")) {  // Se a resposta for "5"
                            minutoDespertar += 5;  // Adia o despertador em 5 minutos
                            respostaErrada = false;  // Resposta correta
                        } else if (respostaUsuario.equals("10")) {  // Se a resposta for "10"
                            minutoDespertar += 10;  // Adia o despertador em 10 minutos
                            respostaErrada = false;  // Resposta correta
                        } else {  // Se a resposta for inválida
                            System.out.println("Resposta inválida! Verifique sua digitação e tente novamente.");  // Exibe mensagem de erro
                            try {
                                Thread.sleep(5000);  // Aguarda 5 segundos
                            } catch (Exception ev) {
                                System.err.println("Erro: " + ev);  // Captura erros ao dormir
                            }
                        }
                    }
                    if (minutoDespertar > 59) {  // Se o minuto ultrapassar 59
                        minutoDespertar -= 59;  // Ajusta para o novo valor de minutos
                        horaDespertar++;  // Incrementa a hora
                        if (horaDespertar > 23) {  // Se a hora for maior que 23
                            horaDespertar = 0;  // Ajusta para hora 0
                        }
                    }
                }
            }

            System.out.println("Agora são: " + horaAtual + "h:" + minutoAtual + "m:" + segundoAtual + "s");  // Exibe a hora atual

            System.out.println("O alarme irá despertar às: " + horaDespertar + "h:" + minutoDespertar + "m");  // Exibe a hora do próximo despertar

            System.out.println("Faltam: " + horaRestante + " hora(s), " + minutoRestante + " minuto(s), " + segundoRestante + " segundos para o próximo alarme.");  // Exibe o tempo restante até o alarme

            try {
                Thread.sleep(1000);  // Aguarda 1 segundo antes de repetir o loop
            } catch (Exception e) {
                System.err.println("Erro: " + e);  // Captura erros ao dormir
            }
        }
        inputScanner.close();  // Fecha o scanner ao encerrar o programa
    }

    public static void clearScreen() {  // Função para limpar a tela
        System.out.print("\033[H\033[2J");  // Comando para limpar a tela no terminal
        System.out.flush();  // Garante que o comando seja executado
    }

    public static synchronized void tocarSom(boolean volumeCrescente) {  // Função para tocar o som do alarme
        new Thread(new Runnable() {  // Cria uma nova thread para tocar o som
            public void run() {  // Método que será executado pela thread
                try {
                    Clip clip = AudioSystem.getClip();  // Cria um novo objeto Clip para tocar o som
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(Despertador.class.getResourceAsStream("./see-you-later-203103.wav"));  // Carrega o arquivo de áudio
                    clip.open(inputStream);  // Abre o arquivo de áudio
                    clip.start();  // Começa a tocar o som

                    if (volumeCrescente == true) {  // Se o volume for crescente
                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);  // Obtém o controle de volume
                        float volumeMinimo = -30.0f;  // Define o volume mínimo
                        float volumeMaximo = 0.0f;  // Define o volume máximo
                        float volumeAumentar = 6.0f;  // Define o valor para aumentar o volume
                        gainControl.setValue(volumeMinimo);  // Define o volume inicial
                        boolean aumentarVolume = true;  // Controla se o volume está aumentando

                        long clipTime;  // Variável para armazenar o tempo do clip
                        while (aumentarVolume == true) {  // Enquanto o volume estiver aumentando
                            if (gainControl.getValue() >= volumeMinimo && gainControl.getValue() <= volumeMaximo) {  // Se o volume estiver dentro do intervalo
                                clipTime = clip.getMicrosecondPosition();  // Obtém a posição atual do áudio
                                clip.stop();  // Para a execução do som
                                gainControl.setValue(gainControl.getValue() + volumeAumentar);  // Aumenta o volume
                                clip.setMicrosecondPosition(clipTime);  // Retorna para a posição anterior do áudio
                                clip.start();  // Recomeça a execução do som
                                try {
                                    Thread.sleep(1000);  // Aguarda 1 segundo
                                } catch (Exception e) {
                                    System.err.println("Erro: " + e);  // Captura erros ao dormir
                                }
                            } else {
                                aumentarVolume = false;  // Se o volume alcançou o limite, interrompe o aumento
                            }
                            System.out.println("gainControl.getValue(): " + gainControl.getValue());  // Exibe o valor atual do volume
                        }
                    } else {
                        clip.stop();  // Para o som
                        clip.start();  // Recomeça o som
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());  // Captura e exibe erros ao tocar o som
                }
            }
        }).start();  // Inicia a execução da thread
    }
}
