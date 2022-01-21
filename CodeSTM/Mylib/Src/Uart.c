/**************************************************************************************/
// Include
/**************************************************************************************/
#include "Uart.h"
/**************************************************************************************/
// Global function
/**************************************************************************************/	
	/**		2
    * @brief		Uart transmit massiv data
    * @param		UART_HandleTypeDef *huart		-	Use Uart 
    * @param		uint8_t *pData							-	Pointer of data
    * @param		uint16_t Size									
    */
		void gUart_Transmit (USART_TypeDef *huart, uint8_t *pData, uint16_t Size)
		{
			uint16_t Count_tx_byte	=	0;
			
			while(Count_tx_byte<Size)
			{
				 while (!LL_USART_IsActiveFlag_TXE(huart)) {}
				LL_USART_TransmitData8(huart,*(uint8_t*)(pData+Count_tx_byte));
				Count_tx_byte++;
			}
			while (!LL_USART_IsActiveFlag_TC(huart)) {}
		}
/************************************************************/
/**
	* @brief		Uart transmit massiv data
	* @param		UART_HandleTypeDef *huart		-	Use Uart 
	* @retval		uint8_t			-	Receive Byte data							
	*/
	uint8_t gUart_Receive_Byte (USART_TypeDef *huart)
	{
		 while (!LL_USART_IsActiveFlag_RXNE(huart)) {}
		return (uint8_t)(READ_BIT(huart->RDR, USART_RDR_RDR));
	}
/************************************************************/
/**
	* @brief		Uart transmit massiv data
	* @param		UART_HandleTypeDef *huart		-	Use Uart 
	* @param		uint8_t *pData							-	Pointer of data					
	* @param		size_t Size									-	Size byte of data				
	*/
	void gUart_Receive (USART_TypeDef *huart,uint8_t *pData, size_t Size)
	{
		for (int i = 0; i < Size; i++) 
		{
			*(pData+i) = READ_BIT(huart->RDR, USART_RDR_RDR);
		}
	}
/************************************************************/
/**
    * @brief		Funcrion transmit prinf massage in uart
    * @param		char *str - massage			
	*/
	void gUart_Terminal_Send (char *str)
	{
		while(*str)
		{
			 while (!LL_USART_IsActiveFlag_TXE(TERMINAL_UART)) {}
			LL_USART_TransmitData8(TERMINAL_UART,(uint8_t)*str++ );
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
