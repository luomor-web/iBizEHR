<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrafficEditViewBase from './trm-traffic-edit-view-base.vue';

import view_form from '@widgets/trm-traffic/main-form/main-form.vue';

/**
 * 交通信息
 *
 * @export
 * @class TrmTrafficEditView
 * @extends {TrmTrafficEditViewBase}
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
export default class TrmTrafficEditView extends TrmTrafficEditViewBase { }
</script>