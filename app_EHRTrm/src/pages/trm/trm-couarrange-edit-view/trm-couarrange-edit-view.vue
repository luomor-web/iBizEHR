<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCouarrangeEditViewBase from './trm-couarrange-edit-view-base.vue';

import view_form from '@widgets/trm-couarrange/main-form/main-form.vue';

/**
 * 培训记录
 *
 * @export
 * @class TrmCouarrangeEditView
 * @extends {TrmCouarrangeEditViewBase}
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
export default class TrmCouarrangeEditView extends TrmCouarrangeEditViewBase { }
</script>