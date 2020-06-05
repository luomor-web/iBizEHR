<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqZZSQJMEditViewBase from './pcm-xygzzsq-zzsqjmedit-view-base.vue';

import view_form from '@widgets/pcm-xygzzsq/xygzz-form/xygzz-form.vue';

/**
 * 试用期员工转正
 *
 * @export
 * @class PcmXygzzsqZZSQJMEditView
 * @extends {PcmXygzzsqZZSQJMEditViewBase}
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
export default class PcmXygzzsqZZSQJMEditView extends PcmXygzzsqZZSQJMEditViewBase { }
</script>