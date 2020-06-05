<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzsqJXSZZSQJMEditViewBase from './pcm-jxsygzzsq-jxszzsqjmedit-view-base.vue';

import view_form from '@widgets/pcm-jxsygzzsq/jxszzsqedit-form-form/jxszzsqedit-form-form.vue';

/**
 * 见习生员工转正
 *
 * @export
 * @class PcmJxsygzzsqJXSZZSQJMEditView
 * @extends {PcmJxsygzzsqJXSZZSQJMEditViewBase}
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
export default class PcmJxsygzzsqJXSZZSQJMEditView extends PcmJxsygzzsqJXSZZSQJMEditViewBase { }
</script>