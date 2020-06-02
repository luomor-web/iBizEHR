<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxJDJLCKEditViewBase from './pcm-ydjdmx-jdjlckedit-view-base.vue';

import view_form from '@widgets/pcm-ydjdmx/main-form/main-form.vue';

/**
 * 借调记录查看
 *
 * @export
 * @class PcmYdjdmxJDJLCKEditView
 * @extends {PcmYdjdmxJDJLCKEditViewBase}
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
export default class PcmYdjdmxJDJLCKEditView extends PcmYdjdmxJDJLCKEditViewBase { }
</script>