/**
 * Main_YGBZD 部件模型
 *
 * @export
 * @class Main_YGBZDModel
 */
export default class Main_YGBZDModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_YGBZDGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_YGBZDGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ormorgid3',
          prop: 'ormorgid3',
          dataType: 'PICKUP',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgid2',
          prop: 'ormorgid2',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'dabh',
          prop: 'dabh',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimarchivesid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimarchivesid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname3',
          prop: 'ormorgname3',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'drda',
          prop: 'drda',
          dataType: 'TEXT',
        },
        {
          name: 'dastate',
          prop: 'dastate',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'sszzdzs',
          prop: 'sszzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'archivescenterid',
          prop: 'archivescenterid',
          dataType: 'PICKUP',
        },
        {
          name: 'archivescentername',
          prop: 'archivescentername',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'dabgd',
          prop: 'dabgd',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimarchives',
          prop: 'pimarchivesid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_dabh_like',
        prop: 'n_dabh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'n_ygzt_eq',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_dastate_eq',
        prop: 'n_dastate_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zt_eq',
        prop: 'n_zt_eq',
        dataType: 'SSCODELIST',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}