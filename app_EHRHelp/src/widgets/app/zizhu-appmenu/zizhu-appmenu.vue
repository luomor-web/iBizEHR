<script lang='ts'>
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '@/crm-core';
import ZIZHUBase from './zizhu-appmenu-base.vue';

/**
 * appmenu基类
 *
 * @export
 * @class ZIZHU
 * @extends {ZIZHUBase}
 */
@Component({
    components: {
         
    }
})
@VueLifeCycleProcessing
export default class ZIZHU extends ZIZHUBase { }
</script>