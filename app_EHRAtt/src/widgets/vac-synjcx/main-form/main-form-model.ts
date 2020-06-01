/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'vacsynjcxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'vacsynjcxname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gly',
        prop: 'gly',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'sjbnts',
        prop: 'sjbnts',
        dataType: 'FLOAT',
      },
      {
        name: 'bnts',
        prop: 'bnts',
        dataType: 'FLOAT',
      },
      {
        name: 'yynj',
        prop: 'yynj',
        dataType: 'FLOAT',
      },
      {
        name: 'synjts',
        prop: 'synjts',
        dataType: 'FLOAT',
      },
      {
        name: 'ksyxsj',
        prop: 'ksyxsj',
        dataType: 'DATE',
      },
      {
        name: 'jsyxsj',
        prop: 'jsyxsj',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'TEXT',
      },
      {
        name: 'vacsynjcxid',
        prop: 'vacsynjcxid',
        dataType: 'GUID',
      },
      {
        name: 'vacsynjcx',
        prop: 'vacsynjcxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}