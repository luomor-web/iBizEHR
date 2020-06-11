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
        prop: 'salsalaryid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salsalaryname',
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
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xc',
        prop: 'xc',
        dataType: 'FLOAT',
      },
      {
        name: 'state',
        prop: 'state',
        dataType: 'SSCODELIST',
      },
      {
        name: 'salplanname',
        prop: 'salplanname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'salsalaryid',
        prop: 'salsalaryid',
        dataType: 'GUID',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'salplanid',
        prop: 'salplanid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'salsalary',
        prop: 'salsalaryid',
        dataType: 'FONTKEY',
      },
    ]
  }

}