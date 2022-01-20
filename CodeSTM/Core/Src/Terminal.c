/**************************************************************************************/
// Include
/**************************************************************************************/
#include "Terminal.h"
/**************************************************************************************/
// Global function
/**************************************************************************************/	
/************************************************************/
/**
    * @brief		Function transmit printf massage in uart
    * @param		char *str - massage			
	*/
	void gTerminal_Send (char *str)
	{
		while(*str)
		{
			 while (!LL_USART_IsActiveFlag_TXE(TERMINAL_UART)) {}
			LL_USART_TransmitData8(TERMINAL_UART,(*str++ & 0x01FF));
		}
	}
/************************************************************/
	/************************************************************/
/**
    * @brief		Function transmit printf massage in uart
    * @param		char *str - buffer			
	*/
	void gTerminal_Recive (char *str,size_t size_Buffer)
	{
		
  uint16_t ind = 0;
  while (!LL_USART_IsActiveFlag_RXNE(TERMINAL_UART)) {}
  str[ind] = (uint8_t)(TERMINAL_UART->DR & 0x00FF);
  while(str[ind])
  {
    ind++;
		if(ind>=size_Buffer){
			break;
		}
    while (!LL_USART_IsActiveFlag_RXNE(TERMINAL_UART)) {}
    str[ind] = (uint8_t)(TERMINAL_UART->DR & 0x00FF);
  }
	}
/************************************************************/
/**************************************************************************************/
//  Local function
/**************************************************************************************/

/**************************************************************************************/
// Other function
/**************************************************************************************/	

/************************************************************/	
