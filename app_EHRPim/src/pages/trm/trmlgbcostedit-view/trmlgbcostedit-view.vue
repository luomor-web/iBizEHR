<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TRMLGBCOSTEditViewBase from './trmlgbcostedit-view-base.vue';

import view_form from '@widgets/trm-lgb-cost/main-form/main-form.vue';

/**
 * 老干部活动管理
 *
 * @export
 * @class TRMLGBCOSTEditView
 * @extends {TRMLGBCOSTEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TRMLGBCOSTEditView extends TRMLGBCOSTEditViewBase { }
</script>