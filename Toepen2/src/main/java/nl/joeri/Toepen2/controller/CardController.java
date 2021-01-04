package nl.joeri.Toepen2.controller;

import nl.joeri.Toepen2.model.Card;
import nl.joeri.Toepen2.model.ChatMessage;
import nl.joeri.Toepen2.model.Game;
import nl.joeri.Toepen2.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If-Match")
@Controller
public class CardController {

    @Autowired
    private SimpMessagingTemplate websocket;

    //Setup some mock data for developing purposes.
    private Player player1 = new Player("John","admin", 1);
    private Player player2 = new Player("Jane","admin",2);
    private Game game = new Game(player1, player2);



    @MessageMapping("/register.player")
    @SendTo("/topic/public")
    public String registerPlayer(Player player){
        if (player1 == null){
            ;
            player1 = new Player(
                    HtmlUtils.htmlEscape(player.getName())
                    ,HtmlUtils.htmlEscape(player.getPassword())
                    ,1);
            return "Successfully registered player 1";
        }
        else if(player2 == null){
            player2 = new Player(
                    HtmlUtils.htmlEscape(player.getName())
                    ,HtmlUtils.htmlEscape(player.getPassword()),
                    2);
            return "Successfully registered player 2";
        }
        else {
            //Maximum players have been reached.
            return "Maximum amount of players has been reached";
        }
    }

    @MessageMapping("/get.cards")
    @SendTo("/topic/public")
    public List<Card> testMessage(@Payload final Player player){
        if (player.getNumber() == 1)
        return player1.getHand();
        else {
            return player2.getHand();
        }
    }

    @MessageMapping("/cards.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage){
        return chatMessage;
    }

    @MessageMapping("/message.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage message,
                               SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }


}

