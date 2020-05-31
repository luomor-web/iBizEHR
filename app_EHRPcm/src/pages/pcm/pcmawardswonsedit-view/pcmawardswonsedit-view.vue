<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMAWARDSWONSEditViewBase from './pcmawardswonsedit-view-base.vue';

import view_form from '@widgets/pcm-awards-wons/main-form/main-form.vue';

/**
 * 获奖情况
 *
 * @export
 * @class PCMAWARDSWONSEditView
 * @extends {PCMAWARDSWONSEditViewBase}
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
export default class PCMAWARDSWONSEditView extends PCMAWARDSWONSEditViewBase { }
</script>