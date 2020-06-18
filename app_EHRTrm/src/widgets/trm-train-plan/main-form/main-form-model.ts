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
        prop: 'trmtrainplanid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmdemdeftionname',
        dataType: 'PICKUPTEXT',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'TEXT',
      },
      {
        name: 'trmdemdeftionname',
        prop: 'trmdemdeftionname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pxdx',
        prop: 'pxdx',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'npxks',
        prop: 'npxks',
        dataType: 'FLOAT',
      },
      {
        name: 'npxqs',
        prop: 'npxqs',
        dataType: 'TEXT',
      },
      {
        name: 'ysze',
        prop: 'ysze',
        dataType: 'FLOAT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmdemdeftionid',
        prop: 'trmdemdeftionid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainplanid',
        prop: 'trmtrainplanid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainplan',
        prop: 'trmtrainplanid',
        dataType: 'FONTKEY',
      },
    ]
  }

}