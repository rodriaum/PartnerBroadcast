# Plugin de Divulgação de Links para Minecraft Java.

## Descrição do Projeto

Este é um plugin básico desenvolvido para servidores Minecraft Java no Bungeecord que permite a divulgação de links por parceiros, YouTubers e streamers. Com este plugin, os jogadores podem usar o comando `/divulgar` seguido pelo link que desejam divulgar. O sistema então exibirá uma mensagem de divulgação no chat, informando que o jogador está compartilhando um link específico.

## Funcionalidades

- Comando `/divulgar`: Permite aos jogadores divulgar links no chat do servidor.
- Mensagem de Divulgação: Quando um jogador usa o comando `/divulgar`, uma mensagem é exibida no chat, informando que o jogador está divulgando um link específico. Por exemplo: "Rodriaum está divulgando um link, acesse em: www.youtube.com/rodriaum".
- Personalização: É possível personalizar as mensagens de divulgação no arquivo de configuração do plugin.

## Como Usar

1. Baixe o plugin e coloque-o na pasta de plugins do seu servidor Bungecord.
2. Reinicie o servidor.
3. Os jogadores com permissão podem usar o comando divulgar da forma: `/divulgar <link>`

## Configurações do Plugin
```yaml
permissions:
  broadcast-partner: 'permission.divulgar'

messages:
  usage-correct: '&cUso correto: /divulgar <link>'
  broadcast-partner: '&b&lSERVIDOR &7» &a%player% está divulgando! &eAcesse: &b%link%'
  without-permission: '&cVocê não possui permissões suficientes.'
  is-console: '&cEste comando só pode ser executado por jogadores.'
