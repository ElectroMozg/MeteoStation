#ifndef Uart_H_
#define Uart_H_

/**************************************************************************************/
// Include
/**************************************************************************************/
//
#include <config.h>
//
/**************************************************************************************/
// Глобальные функции
/**************************************************************************************/
	/**
    * @brief		Uart transmit massiv data
    * @param		UART_HandleTypeDef *huart		-	Use Uart 
    * @param		uint8_t *pData							-	Pointer of data
    * @param		uint16_t Size									
    */
		void gUart_Transmit (USART_TypeDef *huart, uint8_t *pData, uint16_t Size);
	/************************************************************/
	/**
    * @brief		Uart transmit massiv data
    * @param		UART_HandleTypeDef *huart		-	Use Uart 
    * @retval		uint8_t			-	Receive Byte data							
    */
		uint8_t gUart_Receive_Byte (USART_TypeDef *huart);
	/************************************************************/
	/**
		* @brief		Uart transmit massiv data
		* @param		UART_HandleTypeDef *huart		-	Use Uart 
		* @param		uint8_t *pData							-	Pointer of data					
		* @param		size_t Size									-	Size byte of data				
		*/
		void gUart_Receive (USART_TypeDef *huart,uint8_t *pData, size_t Size);
	/************************************************************/
/**************************************************************************************/
// Локальные  функции
/**************************************************************************************/

/**************************************************************************************/
// Неотсортированные фукнции
/**************************************************************************************/

#endif /* Uart_H_*/
