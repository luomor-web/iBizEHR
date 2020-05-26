<script lang='ts'>
import { Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '@/crm-core';
import AppIndexViewBase from './app-index-view-appmenu-base.vue';

/**
 * appmenu基类
 *
 * @export
 * @class AppIndexView
 * @extends {AppIndexViewBase}
 */
@Component({
    components: {
         
    }
})
@VueLifeCycleProcessing
export default class AppIndexView extends AppIndexViewBase { }
</script>