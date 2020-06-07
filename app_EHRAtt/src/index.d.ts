import { UIServiceRegister } from '@/uiservice/ui-service-register';
import { UtilServiceRegister } from '@/utilservice/util-service-register';
import { EntityServiceRegister } from '@/service/entity-service-register';
import { CounterServiceRegister } from '@/counter/counter-service-register';

declare global {
    interface Window {
        uiServiceRegister: UIServiceRegister,
        utilServiceRegister:UtilServiceRegister,
        entityServiceRegister:EntityServiceRegister,
        counterServiceRegister:CounterServiceRegister
    }
}