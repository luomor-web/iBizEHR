<script lang='ts'>
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '@/crm-core';
import IndexBase from './index-appmenu-base.vue';

/**
 * appmenu基类
 *
 * @export
 * @class Index
 * @extends {IndexBase}
 */
@Component({
    components: {
         
    }
})
@VueLifeCycleProcessing
export default class Index extends IndexBase { }
</script>